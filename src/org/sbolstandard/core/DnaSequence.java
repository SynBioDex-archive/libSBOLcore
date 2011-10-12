package org.sbolstandard.core;

import java.net.URI;

/**
 * The SBOL data model's DnaSequence.
 *
 * DNA Sequence holds either the actual sequence string or a reference pointer,
 * a URI to it. The SBOL data model is focused on the description of these DNA
 * sequences as they used in assembly of new synthetic biological systems.
 * Information specifying the exact base pair sequence of DNA components and
 * Sequence Features is very important for the ability to replicate synthetic
 * biology work. Both experimental work and theoretical sequence composition
 * research heavily depends on this information.
 */
public interface DnaSequence {

    public URI getURI();
    public void setURI();

    /**
     * The sequence of DNA base pairs which are described.
     * @return a string representation of the DNA base-pair sequence
     */
    public String getNucleotides();

    /**
     * The sequence of DNA base pairs which are going to be described.
     *
     *  a.The DNA sequence will use the IUPAC ambiguity recommendation. (See
     * http://www.genomatix.de/online_help/help/sequence_formats.html)
     * b.Blank lines, spaces, or other symbols must not be included in the
     * sequence text.
     * c.The sequence text must be in ASCII or UTF-8 encoding. For the alphabets
     * used, the two are identical.
     *
     * @param nucleotides a sequence of [a|c|t|g] letters
     */
    public void setNucleotides(String nucleotides);
}
