/**
 * Created by vinija on 11/23/16.
 */
public class Vertex {

    final private String id;
    final private String name;

    public Vertex(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public boolean isEqual(Object object){

        if(this == object){
            return true;
        } if(object == null){
            return false;
        }if(getClass() != object.getClass()){
            return false;
        }

        Vertex other = (Vertex) object;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public String toString(){
        return name;
    }

}
