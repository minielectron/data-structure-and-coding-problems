package recursions;

public class SecretaryProblem {
    // We have to find the kth order statistics of a stream(We do not know the data in advance)
    // It is an online algorithm
    // We cannot use partition(quick select) because we do not have the entire dataset.
    // Also known as best choice problem
    // We want to hire best secretary out of N applicants


    // check for odds algorithm

    // Solution : The best strategy is to reject the first n/e applicants and then select the one that is better
    // than all the applicants interviewed so far.
}
