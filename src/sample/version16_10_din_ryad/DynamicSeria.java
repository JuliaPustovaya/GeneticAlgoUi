
package sample.version16_10_din_ryad;
import java.util.ArrayList;


public class DynamicSeria {

    private Integer quantity;
    private ArrayList<Points> dynamic_seria;

    public DynamicSeria() {
        this.dynamic_seria = new ArrayList<>();
        this.quantity=0;
    }



    public ArrayList fillSeria(Points p) {
       dynamic_seria.add(p);
       return dynamic_seria;
    }
  public ArrayList fillSeriawithdouble(ArrayList<Double> ps) {
      for (int i = 0; i < ps.size(); i++) {
             Points p= new Points();
             p.setPoint(ps.get(i));
             dynamic_seria.add(p);
      }
      
       return dynamic_seria;
    }
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ArrayList<Points> getDynamic_seria() {
        return dynamic_seria;
    }

    public void setDynamic_seria(ArrayList<Points> dynamic_seria) {
        this.dynamic_seria = dynamic_seria;
    }

}
