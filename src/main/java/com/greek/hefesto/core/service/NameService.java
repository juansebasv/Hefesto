package com.greek.hefesto.core.service;

import com.greek.hefesto.core.domain.NameDO;

/**
 * Service interface for retrieving nationality information based on personal names.
 * <p>
 * This service provides functionality to determine the likely nationality or ethnic
 * origin of a person based on their given name. It leverages statistical analysis
 * and cultural naming patterns to make these determinations.
 * </p>
 *
 * @since 1.0
 */
public interface NameService {

    /**
     * Retrieves nationality information for a given personal name.
     * <p>
     * This method analyzes the provided name and returns a data object containing
     * information about the likely nationality or ethnic origin associated with it.
     * The analysis is based on statistical models and may not be 100% accurate for
     * all names, especially those with multicultural origins.
     * </p>
     *
     * @param name The personal name to analyze, as a String. This should typically
     *             be a first name or given name, but can also be a full name.
     * @return A {@link NameDO} object containing the nationality information
     *         associated with the given name. This includes probabilities for
     *         different nationalities or ethnic origins.
     * @throws IllegalArgumentException if the provided name is null or empty.
     * @throws ServiceException if there's an error during the name analysis process.
     */
    NameDO getNationalityByName(String name);
}