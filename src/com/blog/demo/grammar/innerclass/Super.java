package com.blog.demo.grammar.innerclass;

/*
 * https://blog.csdn.net/chennai1101/article/details/84233647
 */
public class Super {
    private int iValue = 1;

    public static class StaticInner {
        void print(Super sup) {
            System.out.println(sup.iValue);
        }
    }

    public class Inner {
        private int iValue = 2;

        void print() {
            System.out.println(iValue);
            System.out.println(Super.this.iValue);
        }
    }

	public void print() {
		final String strValue = "strValue";
		Thread thread = new Thread() {
			public void run() {
				System.out.println(iValue); // 1
				System.out.println(strValue); // strValue
			}
		};
		thread.start();

        new Thread() {
            public void run() {
                System.out.println(iValue); // 1
                System.out.println(strValue); // strValue
            }
        }.start();
	}

    public static void main(String[] args) {
        Super sup = new Super();
        new StaticInner().print(sup);

        Inner inner = sup.new Inner();
        inner.print();

        sup.print();
	}

}
