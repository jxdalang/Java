package org.tjz.classfier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.tjz.classfier.crawl.CrawlerController;
import org.tjz.classfier.crawl.WebEntity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Classifier {
    private Gson gson = new Gson();
    private Map<String, TypeEntity> trainSet = new HashMap<>();
    private final String TRAIN_PATH = "train2.json";
    private final String TEST_PATH = "test1.json";
    private Type webDataType = new TypeToken<List<WebEntity>>() {
    }.getType();
    private List<WebEntity> trainData = new ArrayList<>();
    private List<WebEntity> testData = new ArrayList<>();

    private void crawlWebData() {
        List<WebEntity> webData = new ArrayList<>();
        CrawlerController crawlerController = new CrawlerController(webData);
        crawlerController.work("http://money.163.com/", 100);
        crawlerController.work("http://ent.163.com/", 100);
        crawlerController.work("http://sports.163.com/", 100);

        int num = 0;
        for (WebEntity web : webData) {
            if (num % 5 == 2) {
                testData.add(web);
            } else {
                trainData.add(web);
            }
            num++;
        }

        String json = gson.toJson(trainData, webDataType);
        try (Writer fw = new BufferedWriter(new FileWriter(TRAIN_PATH))) {
            fw.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        json = gson.toJson(testData, webDataType);
        try (Writer fw = new BufferedWriter(new FileWriter(TEST_PATH))) {
            fw.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<WebEntity> loadWebData(String path) {
        try (Reader fr = new BufferedReader(new FileReader(path))) {
            return gson.fromJson(fr, webDataType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void buildTrainSet() {
        for (WebEntity web : trainData) {
            String type = web.getType();
            if (!trainSet.containsKey(type)) {
                trainSet.put(type, new TypeEntity(type, 0, 0,
                        new HashMap<String, Double>()));
            }

            Map<String, Double> freqData = trainSet.get(type).getFreqData();
            int totalWords = trainSet.get(type).getTotalWords();

            for (String word : web.getWordCount().keySet()) {
                if (word.contains("财经") || word.contains("体育")
                        || word.contains("娱乐") || word.contains("网易")) {
                    continue;
                }

                if (!freqData.containsKey(word)) {
                    freqData.put(word, 1.0);
                    totalWords += 1;
                }

                int count = web.getWordCount().get(word);
                freqData.put(word, freqData.get(word) + count);
                totalWords += count;
            }

            trainSet.get(type).setTotalWords(totalWords);
            trainSet.get(type).setPages(trainSet.get(type).getPages() + 1);
        }

        for (String type : trainSet.keySet()) {
            TypeEntity typeEntity = trainSet.get(type);
            for (String word : typeEntity.getFreqData().keySet()) {
                typeEntity.getFreqData().put(
                        word,
                        typeEntity.getFreqData().get(word)
                                / typeEntity.getTotalWords());
            }
        }

        int total = 0;
        for (TypeEntity tp : trainSet.values()) {
            total += tp.getPages();
        }
        System.out.printf("训练数据信息(共%d个网页)  ", total);

        for (String type : trainSet.keySet()) {
            TypeEntity typeEntity = trainSet.get(type);
            System.out.print(" 类别：" + type + " 网页数：" + typeEntity.getPages() + "  ");
        }
        System.out.println();
    }

    public double calculateNB(Map<String, Integer> wordCount,
            TypeEntity typeEntity) {
        double result = 0.0;
        Map<String, Double> freqData = typeEntity.getFreqData();
        for (String word : wordCount.keySet()) {
            double prob;
            if (freqData.containsKey(word)) {
                prob = freqData.get(word);
            } else {
                prob = 1.0 / typeEntity.getTotalWords();
            }

            result += Math.log10(prob) * wordCount.get(word);
        }

        result += Math.log10(typeEntity.getPages() * 1.0 / trainData.size());

        return result;
    }

    public String classify(WebEntity web) {
        String type = "";
        double maxProb = -100000;
        for (TypeEntity typeEntity : trainSet.values()) {
            double prob = calculateNB(web.getWordCount(), typeEntity);
            if (prob > maxProb) {
                maxProb = prob;
                type = typeEntity.getName();
            }
        }
        return type;
    }

    public void work() {
        File testFile = new File(TEST_PATH);
        File trainFile = new File(TRAIN_PATH);

        if (!testFile.exists() || !trainFile.exists()) {
            crawlWebData();
        } else {
            trainData = loadWebData(TRAIN_PATH);
            testData = loadWebData(TEST_PATH);
        }

        buildTrainSet();

        String type;
        int right = 0;
        for (WebEntity web : testData) {
            type = classify(web);
            System.out.println("标题：" + web.getTitle() + "   实际类别："
                    + web.getType() + " 推测类别：" + type);
            if (web.getType().equals(type)) {
                right++;
            }
        }

        System.out.printf("测试网页个数：%d 准确率：%.2f%%\n", testData.size(), right
                * 100.0 / testData.size());

    }

    public static void main(String[] args) {
        Classifier classifier = new Classifier();
        classifier.work();
    }
}
