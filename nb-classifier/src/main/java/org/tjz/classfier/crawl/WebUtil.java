package org.tjz.classfier.crawl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.apdplat.word.recognition.StopWord;
import org.apdplat.word.segmentation.Segmentation;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.SegmentationFactory;

public class WebUtil {
    private Segmentation segmentation = SegmentationFactory
            .getSegmentation(SegmentationAlgorithm.MaxNgramScore);
    private Map<String, AtomicInteger> statisticsMap = new ConcurrentHashMap<>();
    private boolean removeStopWord = true;

    public Map<String, Integer> getFreqData(String text) {
        statisticsMap.clear();
        segmentation.seg(text).parallelStream().forEach(word -> {
            // 停用词过滤
                if (removeStopWord && StopWord.is(word.getText())) {
                    return;
                }
                statistics(word.getText(), 1, statisticsMap);
            });

        Map<String, Integer> result = new HashMap<String, Integer>();
        for (String key : statisticsMap.keySet()) {
            result.put(key, statisticsMap.get(key).get());
        }
        return result;
    }

    private void statistics(String word, int times,
            Map<String, AtomicInteger> container) {
        container.putIfAbsent(word, new AtomicInteger());
        container.get(word).addAndGet(times);
    }
    
    
}
