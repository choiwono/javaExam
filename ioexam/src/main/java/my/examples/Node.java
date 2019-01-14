package my.examples;

public abstract class Node { // abstract는 상속을 강제하는 일종의 규제!!
    private String parentFolder;
    private String name;
    private long size;

    public Node(String parentFolder, String name) {
        this.parentFolder = parentFolder;
        this.name = name;
    }

    public String getAbsolutePath() {
        return parentFolder + "/" + name;
    }

    public String getParentFolder() {
        return parentFolder;
    }

    public void setParentFolder(String parentFolder) {
        this.parentFolder = parentFolder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Node{" +
                "parentFolder='" + parentFolder + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
