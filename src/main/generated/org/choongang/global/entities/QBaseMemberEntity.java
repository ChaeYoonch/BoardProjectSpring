package org.choongang.global.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseMemberEntity is a Querydsl query type for BaseMemberEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBaseMemberEntity extends EntityPathBase<BaseMemberEntity> {

    private static final long serialVersionUID = -139652596L;

    public static final QBaseMemberEntity baseMemberEntity = new QBaseMemberEntity("baseMemberEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createAt = _super.createAt;

    public final StringPath createdBy = createString("createdBy");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deleteAt = _super.deleteAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath modifiedBy = createString("modifiedBy");

    public QBaseMemberEntity(String variable) {
        super(BaseMemberEntity.class, forVariable(variable));
    }

    public QBaseMemberEntity(Path<? extends BaseMemberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseMemberEntity(PathMetadata metadata) {
        super(BaseMemberEntity.class, metadata);
    }

}

