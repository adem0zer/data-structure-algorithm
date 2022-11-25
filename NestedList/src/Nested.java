import java.util.List;

public class Nested {
    String name;
    List<Nested> nestedList;

    /**
     * get field
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * set field
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get field
     *
     * @return nestedList
     */
    public List<Nested> getNestedList() {
        return this.nestedList;
    }

    /**
     * set field
     *
     * @param nestedList
     */
    public void setNestedList(List<Nested> nestedList) {
        this.nestedList = nestedList;
    }

    @Override
    public String toString() {
        return "Nested{" +
                "name='" + name + '\'' +
                ", nestedList=" + nestedList +
                '}';
    }
}
