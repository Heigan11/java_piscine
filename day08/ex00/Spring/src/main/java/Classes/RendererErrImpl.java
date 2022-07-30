package Classes;

public class RendererErrImpl implements Renderer{
    private PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void printMessage(String text){
        System.err.println(preProcessor.changeText(text));
    }
}
