package pers.xiaoming.notebook.lang.system_and_runtime;

class MyStringWithFinalizer  {
    private String string;

    MyStringWithFinalizer(String string) {
        this.string = string;
    }

    MyStringWithFinalizer append(Object appendStr) {
        return new MyStringWithFinalizer(this.string + appendStr);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("My String " + this.string + " is finalizing!");
        super.finalize();
    }
}
