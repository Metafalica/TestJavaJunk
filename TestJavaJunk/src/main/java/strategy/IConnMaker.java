package strategy;

interface IConnMaker {
    boolean establishConnectionTo(String addr);
}