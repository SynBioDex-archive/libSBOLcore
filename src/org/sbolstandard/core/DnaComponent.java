/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbolstandard.core;


import java.net.URI;
import java.util.Collection;
import java.util.HashSet;

/**
 * The SBOL data model's DnaComponent.
 *
 * This objects of this type represent DNA components for biological engineering
 * which can be described by SequenceAnnotation objects and must specify their
 * DnaSequence object. DnaComponents are expected to be found inside
 * a SBOL Collection object.
 *
 * @author mgaldzic
 * @since 0.6, 08/26/2011
 */

public class DnaComponent {

    private String displayId;
    private String name;
    private String description;
    private boolean isCircular;
    private Collection<URI> type = new HashSet<URI>();
    private DnaSequence dnaSequence;
    private Collection<SequenceAnnotation> annotation = new HashSet<SequenceAnnotation>();

    /**
     * Positions and directions of <code>SequenceFeature</code>[s] that describe
     * the DNA sequence.
     * @return 0 or more <code>SequenceAnnotation</code>[s] that describe the 
     * DNA composition
     * @see addAnnotation
     */
    public Collection<SequenceAnnotation> getAnnotations() {
        return annotation;
    }

    /**
     * New position and direction of a <code>SequenceFeature</code> that
     * describes the DNA sequence.
     * The DnaComponent could be left un-annotated, but that condition is not a very useful to users.
     * @param annotation a <code>SequenceAnnotation</code> that describes the DNA composition
     */
    public void addAnnotation(SequenceAnnotation annotation) {
        if (!getAnnotations().contains(annotation)) {
            getAnnotations().add(annotation);
            //this.feature.add(feature);
        }
    }

    /**
     * Text which is for users to read and interpret what this component is.
     * (eg. engineered Lac promoter, repressible by LacI).
     * Could be lengthy, so it is the responsibility of the user application to
     * format and allow for arbitrary length.
     * @return Human readable text describing the component
     * @see setDescription
     */
    public String getDescription() {
        return description;
    }

    /**
     * Text which is written for users to read and interpret. 
     * It should describe what the component is used for and/or what it does.
     * Suggestion: it should provide information that cannot yet be represented in
     * the rest of the DNA components computable fields. Do not include <> tags
     * such as HTML or XML inside as that may break the RDF. Don't include {}
     * tags as that may break the Json.
     * @param description human readable text describing the component
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Identifier to display to users.
     * @return a human readable identifier
     */
    public String getDisplayId() {
        return displayId;
    }

    /**
     * Identifier that users will see as reference to the DNA construct.
     * It should be unambiguous and is likely imported from source data. Otherwise
     * it should be generated.
     * @todo It should be restricted to alphanumeric/underscore and starting with a
     * letter or underscore.
     * @param displayId a human readable identifier
     */
    public void setDisplayId(String displayId) {
        this.displayId = displayId;
    }

    /**
     * DNA sequence which this DnaComponent object represents.
     * @return 1 {@link DnaSequence} specifying the DNA sequence of this DnaComponent
     * @see DnaSequence
     */
    public DnaSequence getDnaSequence() {
        return dnaSequence;
    }

    /**
     * DNA sequence which this DnaComponent object represents.
     * @param dnaSequence specify the DnaSequence of this DnaComponent
     */
    public void setDnaSequence(DnaSequence dnaSequence) {
        this.dnaSequence = dnaSequence;
    }

    /**
     * The name is the most recognizable known identifier, it is often ambiguous.
     * (eg. pLac-O1) Useful for display to carry common meaning, see work on "shared
     * understanding" in CSCW field for more.
     * @return its name, commonly used to refer to this DnaComponent
     */
    public String getName() {
        return name;
    }

    /**
     * Common name of DNA component, confers meaning of what it is.
     * (eg. pLac-O1) Often this name is the short meaningful string that is
     * informally used to identify the DNA component. Sometimes it is an acronym
     * which makes it likely to be short.
     * @param name its name, commonly used to refer to this DnaComponent (eg. pLac-O1)
     * @see getName
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sequence Ontology vocabulary provides a defined term for types of DNA
     * components.
     * TO DO: implement use of SO within libSBOLj.
     * @return a Sequence Ontology (SO) vocabulary term to describe the type of DnaComponent.
     * @todo When serialized to RDF this is a URI, so when read from persistence it should become
     * one of the SO human readable vocabulary terms. Note:I should allow many types
     */
    public Collection<URI> getTypes() {
        return type;
    }

    /**
     * Sequence Ontology vocabulary provides a defined term for types of DNA
     * components.
     *
     * @param type Sequence Ontology URI specifying the type of the DnaComponent
     * @see setType
     */
    public void addType(URI type) {
        if (!getTypes().contains(type)) {
            getTypes().add(type);
        //this.type.add(type);
        }
    }

    /**
     * Checks whether the other object is an equivalent DnaComponent
     * @param obj other object to be checked for equivalence with this one
     *        (may be null, as specified in generic Object.equals(Object) contract)
     * @return true if another object is equivalent to this one, false otherwise
     *         (including null parameter)
     */

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final DnaComponent other = (DnaComponent) obj;

            if ((this.displayId == null) ? (other.displayId != null) : !this.displayId.equals(other.displayId)) {
                return false;
            }
            if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
                return false;
            }
            if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
                return false;
            }
            if (this.isCircular != other.isCircular) {
                return false;
            }
            if (this.type != other.type && (this.type == null || !this.type.equals(other.type))) {
                return false;
            }
            if (this.dnaSequence != other.dnaSequence && (this.dnaSequence == null || !this.dnaSequence.equals(other.dnaSequence))) {
                return false;
            }
            if (this.annotation != other.annotation && (this.annotation == null || !this.annotation.equals(other.annotation))) {
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
      //  return getRdfId() == null ? 0 : getRdfId().value().hashCode();
        return 0; 
    }
}
