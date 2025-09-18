// XML Data class
class XMLData {
    private String xmldata;

    public XMLData(String data) {
        this.xmldata = data;
    }

    public String getData() {
        return xmldata;
    }
}

// JSON Data class
class JSONData {
    private String jsondata;

    public JSONData(String data) {
        this.jsondata = data;
    }

    public String getData() {
        return jsondata;
    }
}

// Processor works only with XMLData
class Processor {
    private XMLData xmldata;

    public Processor() {}

    public Processor(XMLData data) {
        this.xmldata = data;
    }

    public void processData() {
        System.out.println("Processing XML data and data is: " + xmldata.getData());
    }
}

// Adapter: makes JSONData work with Processor
class Adapter extends Processor {
    private JSONData jsondata;

    public Adapter(JSONData data) {
        this.jsondata = data;
    }

    @Override
    public void processData() {
        System.out.println("Converting JSON data into XML data and JSON data is: " + jsondata.getData());
        XMLData xmldata = new XMLData("Converted data");
        Processor pro = new Processor(xmldata);
        pro.processData();
    }
}

// Driver class
public class AdapterPattern {
    public static void main(String[] args) {
        XMLData data1 = new XMLData("XML Data input");
        JSONData data2 = new JSONData("JSON Data input");

        // Without adapter: Processor expects XMLData only.
        // With adapter: JSONData can also be processed.
        Processor processor = new Adapter(data2);
        processor.processData();
    }
}
