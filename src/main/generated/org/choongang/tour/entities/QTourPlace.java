package org.choongang.tour.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTourPlace is a Querydsl query type for TourPlace
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTourPlace extends EntityPathBase<TourPlace> {

    private static final long serialVersionUID = 1498186236L;

    public static final QTourPlace tourPlace = new QTourPlace("tourPlace");

    public final org.choongang.global.entities.QBaseEntity _super = new org.choongang.global.entities.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final StringPath areaCode = createString("areaCode");

    public final BooleanPath bookTour = createBoolean("bookTour");

    public final StringPath category1 = createString("category1");

    public final StringPath category2 = createString("category2");

    public final StringPath category3 = createString("category3");

    public final NumberPath<Long> contentId = createNumber("contentId", Long.class);

    public final NumberPath<Long> contentTypeId = createNumber("contentTypeId", Long.class);

    public final StringPath cpyrhtDivCd = createString("cpyrhtDivCd");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deleteAt = _super.deleteAt;

    public final NumberPath<Double> distance = createNumber("distance", Double.class);

    public final StringPath firstImage = createString("firstImage");

    public final StringPath firstImage2 = createString("firstImage2");

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public final NumberPath<Integer> mapLevel = createNumber("mapLevel", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final NumberPath<Integer> sigugunCode = createNumber("sigugunCode", Integer.class);

    public final StringPath tel = createString("tel");

    public final StringPath title = createString("title");

    public QTourPlace(String variable) {
        super(TourPlace.class, forVariable(variable));
    }

    public QTourPlace(Path<? extends TourPlace> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTourPlace(PathMetadata metadata) {
        super(TourPlace.class, metadata);
    }

}

