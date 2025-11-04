package Java;
interface CloudHostingProvider {
    void createServer(String region);
    void listServers(String region);
}

interface CDNProvider {
    void getCDNAddress();
}

interface CloudStorageProvider {
    void storeFile(String name);
    void getFile(String name);
}

class Amazon implements CloudHostingProvider, CDNProvider, CloudStorageProvider {

    @Override
    public void createServer(String region) {
        System.out.println("Amazon: Creating server in region " + region);
    }

    @Override
    public void listServers(String region) {
        System.out.println("Amazon: Listing servers in region " + region);
    }

    @Override
    public void getCDNAddress() {
        System.out.println("Amazon: Getting CDN address...");
    }

    @Override
    public void storeFile(String name) {
        System.out.println("Amazon: Storing file " + name);
    }

    @Override
    public void getFile(String name) {
        System.out.println("Amazon: Getting file " + name);
    }
}

class Dropbox implements CloudStorageProvider {

    @Override
    public void storeFile(String name) {
        System.out.println("Dropbox: Storing file " + name);
    }

    @Override
    public void getFile(String name) {
        System.out.println("Dropbox: Getting file " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Amazon amazon = new Amazon();
        amazon.createServer("US-East");
        amazon.listServers("US-East");
        amazon.getCDNAddress();
        amazon.storeFile("photo.jpg");
        amazon.getFile("photo.jpg");

        Dropbox db = new Dropbox();
        db.storeFile("document.pdf");
        db.getFile("document.pdf");
    }
}
