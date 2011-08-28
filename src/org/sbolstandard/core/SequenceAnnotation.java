/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbolstandard.core;

import java.util.Collection;
import java.util.HashSet;

/**
 * The SBOL data model's SequenceAnnotation for RDF and Json.
 *
 * Sequence Annotations give the location and direction of SequenceFeatures of
 * a DnaComponent. The location is specified by the start and stop positions of
 * the Sequence Feature along the DNA sequence. We are using the convention that
 * the first base pair of a DNA sequence is position 1. This convention is
 * established by the broader Molecular biology community, in literature.
 * The direction of the feature is specified by the strand [+/-]. Sequences used
 * are by convention assumed 5' to 3', therefore the <code>+</code> strand is
 * 5' to 3' and the <code>-</code> strand is 3' to 5'.
 *
 * @author mgaldzic
 * @since  0.6, 08/26/2011
 */
public class SequenceAnnotation {

    private Integer genbankStart;
    private Integer end;
    private String strand;
    private Collection<DnaComponent> feature = new HashSet<DnaComponent>();
    private Collection<SequenceAnnotation> preceds = new HashSet<SequenceAnnotation>();

    /**
     *  
     *
     * 
     *
     * @param 
     */
    public Collection<SequenceAnnotation> getPreceds() {
        return preceds;
    }

    /**
     * 
     *
     * 
     *
     * @param 
     */
    public void setPreceds(Collection<SequenceAnnotation> preceds) {
        this.preceds = preceds;
    }


    /**
     * Place a SequenceFeature at this.start, .stop, .strand location.
     *
     * Feature describes this position so it should include the information
     * the users want to be able to get when examining this position.
     *
     * @param feature to describe what is located at this annotation.
     */
    public void addFeature(DnaComponent feature) {
        if (!getFeatures().contains(feature)) {
            getFeatures().add(feature);
            //this.feature.add(feature);
        }
    }

    /**
     * Describe the segments of DNA sequence from start to stop on the strand.
     *
     * The feature has its own displayID, name, description, type, and sequence.
     * Most commonly it is used to describe the sub-sequences of a DnaComponent.
     * Features can be re-used, whenever the SequenceFeature.equals
     * NOTE: the feature could be used as a DnaComponent itself, but this is not
     * implemented in libSBOLj, yet. SbolService does not yet check if an .equals
     * feature exists already.
     * @return collection of any features at this location
     */
    public Collection<DnaComponent> getFeatures() {
        return feature;
    }

    /**
     * First position of the Sequence Feature being annotated.
     *
     * Start coordinate is in terms of the DnaSequence of the DnaComponent
     * annotated.
     *
     * @return positive integer coordinate of first base of the SequenceFeature.
     */
    public int getGenbankStart() {
        return genbankStart;
    }

    /**
     * First position of the feature on the DnaComponent.
     * 
     * Coordinate in terms of the DnaSequence of the DnaComponent annotated.
     *
     * @param genbankStart positive integer coordinate of first base of the SequenceFeature
     */
    public void setGenbankStart(int genbankStart) {
        this.genbankStart = genbankStart;
    }

    /**
     * Last position of the Sequence Feature on the DnaComponent.
     *
     * Coordinate in terms of the DnaSequence of the DnaComponent annotated.
     *
     * @return positive integer coordinate of last base of the SequenceFeature
     */
    public Integer getEnd() {
        return end;
    }

    /**
     * Last position of the feature on the DnaComponent.
     *
     * @param end positive integer coordinate of last base of the SequenceFeature
     */
    public void setEnd(Integer end) {
        this.end = end;
    }

    /**
     * Orientation of feature is the + or - strand.
     * 
     * Sequences used are by convention assumed 5' to 3', therefore the 
     * <code>+</code> strand is 5' to 3' and the <code>-</code> strand 
     * is 3' to 5'.
     *
     * @return <code>+</code> if feature aligns in same direction as DnaComponent,
     *         <code>-</code> if feature aligns in opposite direction as DnaComponent.
     */
    public String getStrand() {
        return strand;
    }

    /**
     * Orientation + or - of the feature relative to the DNA sequence of
     * the DnaComponent. 
     *
     * DnaSequence used is by convention assumed 5' to 3', therefore the
     * <code>+</code> strand is 5' to 3' and the <code>-</code> strand
     * is 3' to 5'.
     *
     * @param strand <code>+</code> if feature aligns in same direction as DnaComponent,
     *               <code>-</code> if feature aligns in opposite direction as DnaComponent.
     */
    public void setStrand(String strand) {
        this.strand = strand;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SequenceAnnotation other = (SequenceAnnotation) obj;
            if (this.genbankStart != other.genbankStart) {
                return false;
            }
            if ((this.end == null) ? (other.end != null) : !this.end.equals(other.end)) {
                return false;
            }
            if ((this.strand == null) ? (other.strand != null) : !this.strand.equals(other.strand)) {
                return false;
            }
            if (this.feature != other.feature && (this.feature == null || !this.feature.equals(other.feature))) {
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
       // return getRdfId() == null ? 0 : getRdfId().value().hashCode();
        return 0;  //change this 
    }
}
