class MyThread extends Thread {
    public void run() {
        // Code to be executed in the new thread
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + ": Count " + i);
        }
    }
}
