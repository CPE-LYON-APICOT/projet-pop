package tp.Model;

public class ItemDecorator {
    protected iItem decoratedItem;

    public ItemDecorator(iItem item){
        this.decoratedItem = item;
    }
}
