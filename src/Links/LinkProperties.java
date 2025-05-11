package Links;

import Entities.Organisation;

import java.util.ArrayList;

public class LinkProperties<T extends Property<?>> extends ArrayList<T> {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (T property : this) {
            sb.append(property.toString());
        }
        sb.append("\n}");
        return sb.toString();
    }

    public String printTree(boolean all){ // print also the properties of the target
        if(all){
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (T property : this) {
                sb.append(property.toString());
                if(property.getTarget() instanceof Organisation){
                    sb.append(((Organisation) property.getTarget()).printProperties(all).replace("\n","\n\t"));
                }
            }
            sb.append("\n}");
            return sb.toString();
        }
        else{
            return toString();
        }
    }

}
