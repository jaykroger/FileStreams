import javax.swing.*;

public class RandProductMakerRunner
{
    public static void main(String[] args)
    {
        RandProductMaker productMaker = new RandProductMaker();

        productMaker.setTitle("Product Maker");
        productMaker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        productMaker.setSize(1080, 660);
        productMaker.setLocation(85, 10);
        productMaker.setVisible(true);
    }
}