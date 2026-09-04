package Locks;

import static java.lang.Thread.sleep;

public class Runnables {
    public static class ReadFileAction implements Runnable {
        private final String path;
        private String result;
        
        public String getResult() {
            return this.result;
        }

        public ReadFileAction(String path) {
            this.path = path;
        }

        @Override
        public void run() {
            try {
                sleep(50); //имитация чтения файла
                this.result = "asd";
            }
            catch (InterruptedException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }    
    
    public static class WriteFileAction implements Runnable {
        private final String path;
        private final String data;

        public WriteFileAction(String path, String data) {
            this.path = path;
            this.data = data;
        }

        @Override
        public void run() {
            try {
                sleep(50); //имитация записи в файл
            }
            catch (InterruptedException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }    
    
    public static class ReadConsoleAction implements Runnable {
        private String result;
        
        public String getResult() {
            return this.result;
        }

        @Override
        public void run() {
            try {
                sleep(50); //имитация ввода пользователя в консоли (пока он там что-то напечатает и нажмет Enter...)
                this.result = "asd";
            }
            catch (InterruptedException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }        
}