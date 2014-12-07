(ns combinator.core)

;; Y = λf. (λx. f (x x)) (λx. f (x x))
;; Y g = g (Y g)
(defn Y [f]
  ((fn [λx] (λx λx))
   (fn [x]
     (fn [& args]
       (apply (f (x x)) args)))))

(defn factorial [number]
  ((Y
    (fn [f]
      (fn [n]
        (if (> n 0)
            (* n (f (dec n)))
            1))))
   number))
