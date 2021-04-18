package dataProvider;

import java.util.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


    public class DataProvider {

        Properties pro;

        public DataProvider() {
            pro = new Properties();
            try {
                pro.load(new FileInputStream(new File("./Config/Config.properties")));
            } catch (Exception e) {

                System.out.println("Not able to read/load config file");
            }
        }

        public String getProducts() {
            return pro.getProperty("ProductsAPI");
        }

        public String getCateogories() {
            return pro.getProperty("CategoriesAPI");
        }
        public String getStores() {
            return pro.getProperty("StoresAPI");
        }
}
