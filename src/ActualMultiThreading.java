class Printer{
    void printDocuments(String name){
        for(int i=0;i<10;i++){
            System.out.println(name +" document number: "+ i + "printing");
        }
    }
}

class MyThread extends Thread{
    Printer printer;
    String name;
    MyThread(Printer pref, String name){
        printer = pref;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (printer){
            printer.printDocuments(name);
        }
    }

}

class YourThread extends Thread{
    Printer printer;
    YourThread(Printer pref){
        printer = pref;
    }

    @Override
    public void run() {
        printer.printDocuments("Sahib");
    }
}

public class ActualMultiThreading {
    public static void main(String[] args) {
        System.out.println("Application Started");
        Printer printer = new Printer();

        MyThread myThread = new MyThread(printer,"Shankar");
        MyThread myThread1 = new MyThread(printer,"Saran");
        myThread.start();
        myThread1.start();

        System.out.println("Application Finished");
    }
}
