package esai.practice;

import java.awt.print.Paper;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by egolesor on 16.08.16.
 */
public class LambdaProblem {


    public static void main(String ... args){
        System.out.println("a" == new String("a"));
        doOperationOnPaper(null, null, e -> e.setSize(1,1));



        doOperationOnPaper(null, null, new Consumer<Paper>() {
            @Override
            public void accept(Paper paper) {
                paper.setSize(1,1);
            }
        });

    }

    static void doOperationOnPaper(List<Paper> listOfPersons, Paper myPaper, Consumer<Paper> function){
        for(Paper paper : listOfPersons){
            if(paper.equals(myPaper)){
                function.accept(paper);
            }
        }
    }

    class MyInnerClass{}

    static class StaticMyInnerClass{}


}
