import Pages.*;
import javafx.scene.layout.Priority;
import org.testng.annotations.Test;

public class Category_Tests {


    Categories categories = new Categories();


    @Test(priority = 1)
    public void CategoryStatusTest(){

        categories.getCateogories();

    }
    @Test(priority = 2) //change ID to unique ID by default it is now unique id but after 1 run it needs to be changed
    public void PostCateogories() {

        categories.PostCateogories();
    }
    @Test (priority = 3)
    public void DeletCateogories(){

        categories.DeletCategory();
    }
}
