package org.sbolstandard.core;

import java.net.URI;
import java.util.HashSet;
import java.util.Collection;

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
 */
public interface SequenceAnnotation {

    public URI getURI();
    public void setURI();

    public Collection<SequenceAnnotation> getPrecedes();
    public void addPrecede(SequenceAnnotation precede);

    public void setSubComponent(DnaComponent subComponent);
    public DnaComponent getSubComponent();

    /**
     * First position of the Sequence Feature being annotated.
     * Start coordinate is in terms of the DnaSequence of the DnaComponent
     * annotated.
     * @return positive integer coordinate of first base of the SequenceFeature.
     */
    public int getBioStart();
    public void setBioStart(int bioStart);

    /**
     * Last position of the Sequence Feature on the DnaComponent.
     * Coordinate in terms of the DnaSequence of the DnaComponent annotated.
     * @return positive integer coordinate of last base of the SequenceFeature
     */
    public int getBioEnd();
    public void setBioEnd(int bioEnd);

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
    public String getStrand();
    public void setStrand(String strand);

}
