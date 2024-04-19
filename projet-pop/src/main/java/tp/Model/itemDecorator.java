package tp.Model;

class itemDecorator extends basicItem{

    protected iItem decoratedItem;

    public itemDecorator(iItem item){
        this.decoratedItem = item;
    }
    
}
