package rat;

import resources.DbHandler;

public class Rat {
    public static void main(String[] args) {
        DbHandler dbH = new DbHandler();

        boolean status = dbH.isConnected();

        System.out.println(status);

    }
}
