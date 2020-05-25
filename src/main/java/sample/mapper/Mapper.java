package sample.mapper;



/**
 * Mapper.java is  a inyerface that has the following methods
 *
 * @author Goga Andrei
 *
 */
public interface Mapper<ENTITY, DTO> {

    ENTITY mapTo(DTO DTO);
    DTO mapFrom(ENTITY ENTITY);

}
