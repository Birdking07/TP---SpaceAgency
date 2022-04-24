package TP2.Analysers;

import java.util.ArrayList;

public abstract class AnalyserFormat {

    public abstract boolean Sequence(String chain , String sequence); //returns true if a sequence is present in selected chain

    public abstract boolean AllSequences(String chain , ArrayList<String> sequenceList); //returns true if one of the sequences is present

    public abstract boolean OneSequenceCount(String chain , String sequence , int objective); //returns true if a string is present x times within a sequence

    public abstract boolean AllSequencesCount(String chain , ArrayList<String> sequenceList , int objective); //returns true if all sequences are present x times
}
