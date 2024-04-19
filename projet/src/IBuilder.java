import java.util.logging.Level;

/* import java.util.Map.Entry;
 *
 * Liste des éléments d'un niveau : 
 *  - Murs
 *  - Fruits
 *  - Bonbons
 *  - Objet à effet
 *  - Objets spéciaux
 *  - Possiblement des méchants
 *  - 
 */ 

interface IBuilder {
    public void reset();
    public void setWalls();
    public void setFruits();
    public Level getLevel();
}