abstract class Item {

    protected Integer x;
    protected Integer y;

    public Item(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    /*
     * public SpecialEffects getEffect() {
     * return SpecialEffects.EFFET1;
     * }
     */
    public String getPosition(Item unItem) {
        return "x : " + unItem.x + "\n y : " + unItem.y;
    }
}
