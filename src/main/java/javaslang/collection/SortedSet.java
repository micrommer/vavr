/*     / \____  _    _  ____   ______  / \ ____  __    _ _____
 *    /  /    \/ \  / \/    \ /  /\__\/  //    \/  \  / /  _  \   Javaslang
 *  _/  /  /\  \  \/  /  /\  \\__\\  \  //  /\  \ /\\/  \__/  /   Copyright 2014-now Daniel Dietrich
 * /___/\_/  \_/\____/\_/  \_/\__\/__/___\_/  \_//  \__/_____/    Licensed under the Apache License, Version 2.0
 */
package javaslang.collection;

import javaslang.Tuple2;
import javaslang.control.Option;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * An immutable {@code SortedSet} interface.
 *
 * @param <T> Component type
 * @author Daniel Dietrich
 * @since 2.0.0
 */
public interface SortedSet<T> extends Set<T> {

    /**
     * Returns the underlying comparator which defines the order of the elements contained in this set.
     *
     * @return This set's comparator.
     */
    Comparator<T> comparator();

    /**
     * Same as {@link #flatMap(Function)} but using a specific comparator for values of the codomain of the given
     * {@code mapper}.
     *
     * @param comparator A comparator for values of type U
     * @param mapper     A function which maps values of type T to Iterables of values of type U
     * @param <U>        Type of flat-mapped values
     * @return A new Set instance containing mapped values
     */
    <U> SortedSet<U> flatMap(Comparator<? super U> comparator, Function<? super T, ? extends java.lang.Iterable<? extends U>> mapper);

    /**
     * Same as {@link #map(Function)} but using a specific comparator for values of the codomain of the given
     * {@code mapper}.
     *
     * @param comparator A comparator for values of type U
     * @param mapper     A function which maps values of type T to values of type U
     * @param <U>        Type of mapped values
     * @return A new Set instance containing mapped values
     */
    <U> SortedSet<U> map(Comparator<? super U> comparator, Function<? super T, ? extends U> mapper);

    // -- Adjusted return types of Set methods

    @Override
    SortedSet<T> add(T element);

    @Override
    SortedSet<T> addAll(java.lang.Iterable<? extends T> elements);

    @Override
    SortedSet<T> clear();

    @Override
    SortedSet<T> diff(Set<? extends T> elements);

    @Override
    SortedSet<T> distinct();

    @Override
    SortedSet<T> distinctBy(Comparator<? super T> comparator);

    @Override
    <U> SortedSet<T> distinctBy(Function<? super T, ? extends U> keyExtractor);

    @Override
    SortedSet<T> drop(int n);

    @Override
    SortedSet<T> dropRight(int n);

    @Override
    SortedSet<T> dropUntil(Predicate<? super T> predicate);

    @Override
    SortedSet<T> dropWhile(Predicate<? super T> predicate);

    @Override
    SortedSet<T> filter(Predicate<? super T> predicate);

    @Override
    <U> SortedSet<U> flatMap(Function<? super T, ? extends java.lang.Iterable<? extends U>> mapper);

    @Override
    <U> SortedSet<U> flatten();

    @Override
    <C> Map<C, ? extends SortedSet<T>> groupBy(Function<? super T, ? extends C> classifier);

    @Override
    Iterator<? extends SortedSet<T>> grouped(int size);

    @Override
    SortedSet<T> init();

    @Override
    Option<? extends SortedSet<T>> initOption();

    @Override
    SortedSet<T> intersect(Set<? extends T> elements);

    @Override
    default T last() {
        return max().orElseThrow(() -> new NoSuchElementException("last on empty SortedSet"));
    }

    @Override
    <U> SortedSet<U> map(Function<? super T, ? extends U> mapper);

    @Override
    Tuple2<? extends SortedSet<T>, ? extends SortedSet<T>> partition(Predicate<? super T> predicate);

    @Override
    SortedSet<T> peek(Consumer<? super T> action);

    @Override
    SortedSet<T> remove(T element);

    @Override
    SortedSet<T> removeAll(java.lang.Iterable<? extends T> elements);

    @Override
    SortedSet<T> replace(T currentElement, T newElement);

    @Override
    SortedSet<T> replaceAll(T currentElement, T newElement);

    @Override
    SortedSet<T> retainAll(java.lang.Iterable<? extends T> elements);

    @Override
    SortedSet<T> scan(T zero, BiFunction<? super T, ? super T, ? extends T> operation);

    // DEV-NOTE: The return type is either Set or SortedSet, depending whether U is Comparable
    @Override
    <U> Set<U> scanLeft(U zero, BiFunction<? super U, ? super T, ? extends U> operation);

    // DEV-NOTE: The return type is either Set or SortedSet, depending whether U is Comparable
    @Override
    <U> Set<U> scanRight(U zero, BiFunction<? super T, ? super U, ? extends U> operation);

    @Override
    Iterator<? extends SortedSet<T>> sliding(int size);

    @Override
    Iterator<? extends SortedSet<T>> sliding(int size, int step);

    @Override
    Tuple2<? extends SortedSet<T>, ? extends SortedSet<T>> span(Predicate<? super T> predicate);

    @Override
    SortedSet<T> tail();

    @Override
    Option<? extends SortedSet<T>> tailOption();

    @Override
    SortedSet<T> take(int n);

    @Override
    SortedSet<T> takeRight(int n);

    @Override
    SortedSet<T> takeUntil(Predicate<? super T> predicate);

    @Override
    SortedSet<T> takeWhile(Predicate<? super T> predicate);

    @Override
    SortedSet<T> union(Set<? extends T> elements);

    @Override
    <T1, T2> Tuple2<? extends SortedSet<T1>, ? extends SortedSet<T2>> unzip(Function<? super T, Tuple2<? extends T1, ? extends T2>> unzipper);

    @Override
    <U> SortedSet<Tuple2<T, U>> zip(java.lang.Iterable<U> that);

    @Override
    <U> SortedSet<Tuple2<T, U>> zipAll(java.lang.Iterable<U> that, T thisElem, U thatElem);

    @Override
    SortedSet<Tuple2<T, Integer>> zipWithIndex();

}
