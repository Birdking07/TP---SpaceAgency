package TP2.Analysers;

public abstract class AnalyserFormat {

    public abstract boolean analyse(String chain , String test); // retourne true si le format est bon

    protected abstract boolean Sequence(); //returns true if a sequence is present in selected chain

    protected abstract boolean AllSequences(); //returns true if one of the sequences is present

    protected abstract boolean OneSequenceCount(); //returns true if a string is present x times within a sequence

    protected abstract boolean AllSequencesCount(); //returns true if all sequences are present x times
}
