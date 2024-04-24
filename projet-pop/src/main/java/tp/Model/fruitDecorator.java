package tp.Model;
class fruitDecorator extends ItemDecorator {

    public fruitDecorator(iItem fruit){
        super(fruit);
    }

    @Override
    public Integer getPoints() {
        return super.getPoints() + 1;
    }

}

