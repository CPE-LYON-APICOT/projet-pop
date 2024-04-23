package tp.Model;

public abstract class ItemDecorator implements iItem{
    protected iItem decoratedItem;

    public ItemDecorator(iItem item){
        this.decoratedItem = item;
    }
}
