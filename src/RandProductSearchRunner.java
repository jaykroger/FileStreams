import javax.swing.*;

public class RandProductSearchRunner
{
    public static void main(String[] args)
    {
        RandProductSearch productSearch = new RandProductSearch();

        productSearch.setTitle("Product Search");
        productSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        productSearch.setSize(1080, 660);
        productSearch.setLocation(85, 10);
        productSearch.setVisible(true);
    }
}
