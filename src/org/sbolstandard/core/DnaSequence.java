/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbolstandard.core;

//import org.apache.commons.codec.binary.Hex;

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
 *
 * @author mgaldzic
 * @since  0.6, 08/26/2011
 */
public class DnaSequence {
    private String nucleotides;

    /**
     * The sequence of DNA base pairs which are described.
     * @return a string representation of the DNA base-pair sequence
     * @see setDnaSequence
     */
    public String getNucleotides() {
        return nucleotides;
    }

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
    public void setNucleotides(String nucleotides) {
        this.nucleotides = nucleotides;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DnaSequence other = (DnaSequence) obj;
            if ((this.nucleotides == null) ? (other.nucleotides != null) : !this.nucleotides.equals(other.nucleotides)) {
                return false;
            }
        return true;
    }

    @Override
    public int hashCode() {
       // return getRdfId() == null ? 0 : getRdfId().value().hashCode();
        return 0; // consider the hash based on org.apache.commons.codec.binary.Hex
    }
}
