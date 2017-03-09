package example.java;

public class Bar {
    private final String name;
    private final String address;
    private final String owner;

    private Bar(String name, String address, String owner) {
        this.name = name;
        this.address = address;
        this.owner = owner;
    }

    public static void main(String[] args) {
        System.out.println(BarBuilder.start().setName("Joe's Bar").setAddress("Main St").setOwner("Joe").createBar());
        System.out.println(new BarBuilder().setAddress("Joe").setOwner("Main St.").createBar().name);
    }

    interface NameStep {
        AddressStep setName(String name);
    }

    interface AddressStep {
        OwnerStep setAddress(String address);
    }

    interface OwnerStep {
        CreateStep setOwner(String owner);
    }

    interface CreateStep {
        Bar createBar();
    }

    public static class BarBuilder implements NameStep, AddressStep, OwnerStep, CreateStep {

        private String name;
        private String address;
        private String owner;

        public static NameStep start() {
            return new BarBuilder();
        }

        public BarBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BarBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public BarBuilder setOwner(String owner) {
            this.owner = owner;
            return this;
        }

        public Bar createBar() {
            return new Bar(name, address, owner);
        }
    }
}
