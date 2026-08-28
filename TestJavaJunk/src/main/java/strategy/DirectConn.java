package strategy;

class DirectConn implements IConnMaker {
    @Override
    public boolean establishConnectionTo(String addr) {
        System.out.println("Direct connection established");
        return true;
    }
}