import Pages.*;
import org.testng.annotations.Test;

public class Products_test {

    Products products = new Products();


    @Test (priority = 1)
    public void getStatuscode(){
        products.GetStatusCode();
    }

    @Test (priority = 2)
    public void getProducts(){
        products.PostProduct();
   }

    @Test (priority = 3)
    public void ProductNames(){
        products.ProductNames();
   }

     @Test (priority = 4)
     public void ProductType(){
       products.VerifyProductType();
   }
}
