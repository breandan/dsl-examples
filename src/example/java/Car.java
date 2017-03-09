package example.java;

class Car {
    private Engine e;
    private Transmission t;
    private Stereo s;

    Car(Builder<OK, OK> b) {
        e = b.engine;
        t = b.transmission;
        s = b.stereo;
    }

    private Car(Engine e, Transmission t, Stereo s) {
        this.e = e;
        this.t = t;
        this.s = s;
    }


    static void main(String[] args) {
        Car c0 = new Car(Builder.create().engine(new Engine()).transmission(new Transmission()));
        Car c1 = new Car(Builder.create().transmission(new Transmission()).engine(new Engine()));
        Car c2 = new Car(Builder.create().stereo(new Stereo()).transmission(new Transmission()).engine(new Engine()));
//        Car c3 = new Car(Builder.create().engine(new Engine()).stereo(new Stereo())); //Compiler error
    }
}

class Engine { }

class Transmission { }

class Stereo { }

abstract class OK { }

abstract class NO { }

class Builder<E, T> {
    Stereo stereo;
    Transmission transmission;
    Engine engine;

    private Builder(Engine engine, Transmission t, Stereo s) {
        this.engine = engine;
        this.transmission = t;
        this.stereo = s;
    }

    static Builder<NO, NO> create() {
        return new Builder<>(null, null, null);
    }

    Builder<OK, T> engine(Engine e) {
        this.engine = e;
        return new Builder<>(engine, transmission, stereo);
    }

    Builder<E, OK> transmission(Transmission t) {
        this.transmission = t;
        return new Builder<>(engine, transmission, stereo);
    }

    Builder<E, T> stereo(Stereo s) {
        this.stereo = s;
        return new Builder<>(engine, transmission, stereo);
    }
}
