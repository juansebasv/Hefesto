package com.greek.hefesto.ports.output.gateway;

import com.greek.hefesto.core.domain.NameDO;

/**
 * Port interface for name-based nationality retrieval operations.
 */
public interface NamePort {

    /**
     * Retrieves nationality information based on the given name.
     *
     * @param name The name to analyze for nationality.
     * @return A {@link NameDO} containing the nationality data.
     */
    NameDO getNationalityByName(String name);
}