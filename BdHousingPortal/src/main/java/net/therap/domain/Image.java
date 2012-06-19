package net.therap.domain;

import javax.persistence.*;
import java.sql.Blob;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/13/12
 * Time: 4:56 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "H_IMAGE")
public class Image {

    private long imageId;
    private Flat flat;
    private Blob imageData;

    @Lob
    @Column(name = "IMAGE_DATA")
    public Blob getImageData() {
        return imageData;
    }

    public void setImageData(Blob imageData) {
        this.imageData = imageData;
    }

    @Id
    @SequenceGenerator(name = "H_IMAGE_SEQ", sequenceName = "H_IMAGE_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "H_IMAGE_SEQ")
    @Column(name = "IMAGE_ID")
    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    @OneToOne
    @JoinColumn(name = "FLAT_ID")
    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }


}
