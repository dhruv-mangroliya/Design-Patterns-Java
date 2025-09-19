abstract class Template{
    abstract public void a();
    abstract public void b();
    abstract public void c();
    abstract public void d();

    public final void execute(){
        a();
        b();
        d();
        c();
    }
}

class Follower1 extends Template{
    @Override
    public void a(){
        System.out.println("follower 1 a");
    }
    @Override
    public void b(){
        System.out.println("follower 1 b");
    }
    @Override
    public void c(){
        System.out.println("follower 1 c");
    }
    @Override
    public void d(){
        System.out.println("follower 1 d");
    }
}

class Follower2 extends Template{
    @Override
    public void a(){
        System.out.println("follower 2 a");
    }
    @Override
    public void b(){
        System.out.println("follower 2 b");
    }
    @Override
    public void c(){
        System.out.println("follower 2 c");
    }
    @Override
    public void d(){
        System.out.println("follower 2 d");
    }
}

public class TemplateMethodPattern {
    public static void main(String[] args){
        Template t1 = new Follower1();
        t1.execute();

        Template t2 = new Follower2();
        t2.execute();
        return;
    }
}
