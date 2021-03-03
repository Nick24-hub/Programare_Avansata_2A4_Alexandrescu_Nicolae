public abstract class Algorithm {
    protected Problem problemData;

    // Getter si setter

    protected abstract Problem getProblemData();

    protected abstract void setProblemData(Problem problemData);

    // Metoda solve() ce implementeaza un algoritm si returneaza o solutie
    protected abstract Solution solve();

}
