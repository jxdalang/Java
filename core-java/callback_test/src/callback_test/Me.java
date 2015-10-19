package callback_test;

public class Me { // 客户端

	private void hasQuestion() {
		// 现在有问题想不出来答案，想去问你
		You you = new You();
		you.setCallBack("蜗牛", "某道题答案是什么？", new ContactInterface() { // 匿名内部类

			@Override
			// implements ContactInterface
			public void callBackByTel(String answer) {
				System.out.println("我说：嗯，好的，我收到答案了:" + answer + "，谢谢");

			}
		});
		// 你接到电话，起床开始思考问题
		new Thread(you).start();
	}

	// test method
	public static void main(String[] args) {

		Me me = new Me();
		me.hasQuestion();

	}

}