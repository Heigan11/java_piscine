package Classes;

public class RendererStandardImpl implements Renderer{

    private PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void printMessage(String text){
        System.out.println(preProcessor.changeText(text));
    }

}
