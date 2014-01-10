(require 's)


(defun imp-clj-html (buffer)
  (with-current-buffer (get-buffer buffer)
    (cider-eval-defun-at-point))
  (let* ((content (with-temp-buffer 
		    (cider-interactive-eval-print "(fioritto.sketch/page)")
		    (sleep-for 0.1)
		    (buffer-string)))
	 (sanitized-content (s-replace-all '(("\\n" . "") ("\\\"" . "'")) content)))
    (princ sanitized-content (current-buffer))
    )
  (delete-region (point-min) (+ (point-min) 1))
  (delete-region (- (point-max) 1) (point-max)))
