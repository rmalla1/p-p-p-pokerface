(ns p-p-p-pokerface)


(defn rank [card]
  (let [[f s] card]
      (replacements f)
    )
  )

(rank "2H") ;=> 2
(rank "4S")
(rank "TS")
(rank "AS")


(defn suit [card]
  (let [[fst scnd] card]
    (str scnd)
    )
  )

(suit "2H")
(suit "2C") ;=> "C"


(def high-seven                   ["2H" "3S" "4C" "5C" "7D"])
(def pair-hand                    ["2H" "2S" "4C" "5C" "7D"])
(def two-pairs-hand               ["2H" "2S" "4C" "4D" "7D"])
(def three-of-a-kind-hand         ["2H" "2S" "2C" "4D" "7D"])
(def four-of-a-kind-hand          ["2H" "2S" "2C" "2D" "7D"])
(def straight-hand                ["2H" "3S" "6C" "5D" "4D"])
(def low-ace-straight-hand        ["2H" "3S" "4C" "5D" "AD"])
(def high-ace-straight-hand       ["TH" "AS" "QC" "KD" "JD"])
(def flush-hand                   ["2H" "4H" "5H" "9H" "7H"])
(def full-house-hand              ["2H" "5D" "2D" "2C" "5S"])
(def straight-flush-hand          ["2H" "3H" "6H" "5H" "4H"])
(def low-ace-straight-flush-hand  ["2D" "3D" "4D" "5D" "AD"])
(def high-ace-straight-flush-hand ["TS" "AS" "QS" "KS" "JS"])

(defn pair? [hand]
  ;(> (apply max (vals (frequencies hand))) 1)

   (> (apply max (vals (frequencies (map rank  hand)))) 1)

  )

(pair? pair-hand)
(pair? high-seven)


(defn three-of-a-kind? [hand]
    (= (apply max (vals (frequencies (map rank  hand)))) 3)
  )

(three-of-a-kind? two-pairs-hand)
(three-of-a-kind? three-of-a-kind-hand)

(defn four-of-a-kind? [hand]
     (= (apply max (vals (frequencies (map rank  hand)))) 4)
  )

(four-of-a-kind? two-pairs-hand)
(four-of-a-kind? four-of-a-kind-hand)

(defn flush? [hand]
  (= 1 (count (keys (frequencies (map suit hand)))))
  )


(flush? pair-hand)
(flush? flush-hand)

(range 3 (+ 3 5))

(defn full-house? [hand]
  (let [two-kind  (= 2 (some #{2} (vals (frequencies (map rank hand)))))]
      (and (three-of-a-kind? hand) two-kind)
    )

  )





(full-house? three-of-a-kind-hand)
(full-house? full-house-hand)



(defn two-pairs? [hand]
   (let [x (frequencies (map rank hand))]
       ;(println (some #{4} (keys (frequencies (vals x)))))
       (or (= 2 (some #{2} (vals (frequencies (vals x))))) (= 4 (some #{4} (keys (frequencies (vals x))))))
     )
  )


(two-pairs? two-pairs-hand)
(two-pairs? pair-hand)
(two-pairs? four-of-a-kind-hand)

(defn straight? [hand]
    (let [x (map rank hand) x1 (replace {14 1} x) ]
      ;(print (replace {14 1} (sort x)))
      (let [f (first (sort x)) f1 (first (sort x1))]
         (or (= (sort x) (range f (+ f 5))) (= (sort x1) (range f1 (+ f1 5))) )
        )
     )
  )

(range 2 (+ 2 5))
(straight? straight-hand)
(straight? two-pairs-hand)
(straight? low-ace-straight-hand)
(straight? ["2H" "2D" "3H" "4H" "5H"])
(straight? high-ace-straight-hand)

(defn straight-flush? [hand]
  (and (straight? hand) (flush? hand))
  )

(straight-flush? straight-hand)
(straight-flush? straight-flush-hand)
(straight-flush? high-ace-straight-flush-hand)

(defn value [hand]
  (let [checkers #{[high-card? 0]  [pair? 1]
                 [two-pairs? 2]  [three-of-a-kind? 3]
                 [straight? 4]   [flush? 5]
                 [full-house? 6] [four-of-a-kind? 7]
                 [straight-flush? 8]}]

  )
)
